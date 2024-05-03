import React, { useEffect, useRef, useState } from "react";
import axios from "axios";
import { LETTER_SCORES, ENDPOINT_URL } from "../constants/constant";


function Scrabble() {
    const [tiles, setTiles] = useState(Array(10).fill(''));
    const [score, setScore] = useState(0);
    const [scoreList, setScoreList] = useState([]);
    const inputRef = useRef([]);
    const api = axios.create({
        baseURL: ENDPOINT_URL, // Set your base URL here
    });

    const handleSaveScore = () => {
        if (score) {
            api.post(ENDPOINT_URL, {
                "score": score
            })
                .then(response => {
                    alert('Score saved successfully - ' + response.data.score)
                }).catch(error => {
                    console.error(error);
                })
        } else {
            alert('Score is not correct!!!')
        }
    }

    const handleViewTopScores = (e) => {
        api.get().then(response => {
            if (response.data.length > 0) {
                setScoreList(response.data.map((m) => (m.score)))
            } else {
                alert('No score saved, please save the score!')
            }
        }).catch(error => {
            console.log(error)
        })
    }

    const calculateScore = (index, e) => {

        const letter = e.target.value;
        const regex = /^[a-zA-Z]+$/;
        if (!letter || regex.test(letter)) {
            const newInputs = [...tiles];
            newInputs[index] = letter.toUpperCase();
            setTiles(newInputs);

            if (letter && index < newInputs.length - 1 && regex.test(letter)) {
                inputRef.current[index + 1].focus();
            }
            setScore(calculateEachLeterScore(newInputs));
        } else {
            alert('Please enter only letters!!!')
        }
    }

    function calculateEachLeterScore(numbers) {
        if (!Array.isArray(numbers) || !numbers.length) {
            return 'Invalid input: Please provide an array of numbers.';
        }

        const numberArray = [];
        for (const currentValue of numbers) {
            if (currentValue)
                numberArray.push(LETTER_SCORES[currentValue]);
        }

        const total = numberArray.reduce((accumulator, currentValue) => accumulator + currentValue, 0);
        
        return total;
    }

    const handleReset = () => {
        setTiles(Array(tiles.length).fill(''));
        setScore(0);
        setScoreList([])
    };
    const onKeyDownHandler = (e, index) => {
        if (e.key === "Backspace" && index > 0 && !tiles[index]) {
            inputRef.current[index - 1].focus();
        }
    };
    const onClickHandler = (index) => inputRef.current[index].setSelectionRange(1, 1);


    useEffect(() => {
        if (inputRef.current[0]) inputRef.current[0].focus();
    }, []);

    const renderTiles = () => {

        return tiles.map((tile, index) => (
            <input
                key={index}
                value={tile}
                className="scrabble-box"
                data-testid={"scrabble-tile-"+index}
                maxLength={1}
                ref={(input) => (inputRef.current[index] = input)}
                onChange={(e) => calculateScore(index, e)}
                onKeyDown={(e) => onKeyDownHandler(e, index)}
                onClick={() => onClickHandler(index)}
            />
        ));
    };

    return (
        <div>
            <h1> Scrabble Points Calculator</h1>
            <h3>Please Enter Letters : </h3>
            <div>{renderTiles()}</div>

            <h3><p>Score: {score}</p></h3>
            <h3>View Top 10 Scores:</h3>
            <ul>
                {scoreList.map((sl, index) => (
                    <li key={index}>{sl}</li>
                ))}
            </ul>
            <button onClick={handleReset} className="btn default">Reset Tiles</button>
            <button onClick={handleSaveScore} className="btn default">Save Score</button>
            <button onClick={(e) => handleViewTopScores(e)} className="btn default">View Top Scores</button>

        </div>
    );
}
export default Scrabble;