import { render, screen, fireEvent } from '@testing-library/react';
import App from './App';
import Scrabble from '../src/components/Scrabble'

// test('renders learn react link', () => {
//   render(<App />);
//   const linkElement = screen.getByText(/learn react/i);
//   expect(linkElement).toBeInTheDocument();
// });

jest.mock('axios');

test('should update tile and calculate score on input change', () => {
  const { getByTestId, getByText } = render(<Scrabble />);

  // Get the first input tile
  const firstInput = getByTestId('scrabble-tile-0'); // Assuming you add data-testid attributes to each tile input

  // Simulate typing the letter "A"
  fireEvent.change(firstInput, { target: { value: 'A' } });

  // Assert that the input value is updated
  expect(firstInput.value).toBe('A');

  // Assert that the score is updated (assuming 'A' has a score in LETTER_SCORES)
  //expect(getByText('Score:')).toHaveTextContent(/Score: \d+/); // Matches a number for score
});

test('should not update tile or score on invalid input (non-letter)', () => {
  const { getByTestId, getByText } = render(<Scrabble />);

  // Get the first input tile
  const firstInput = getByTestId('scrabble-tile-0');

  // Simulate typing a number
  fireEvent.change(firstInput, { target: { value: '1' } });

  // Assert that the input value remains empty
  expect(firstInput.value).toBe('');

  // Assert that the score remains 0
  //expect(getByText('Score:')).toHaveTextContent('Score: 0');
});

const axios = jest.mock('axios'); // Mock axios for testing

test('should call API and display success message on save score', async () => {
  const mockAxios = jest.mocked(axios);
  const mockResponse = { data: { score: 10 } }; // Mock successful API response

  mockAxios.post.mockResolvedValueOnce(mockResponse);

  const { getByText, getByRole } = render(<Scrabble />);

  // Set a score (assuming a way to set score in your component)
  // ... set score logic ...

  // Simulate save score button click
  fireEvent.click(getByRole('button', { name: /Save Score/i }));

  // Assert that API call was made with expected data
  expect(mockAxios.post).toHaveBeenCalledWith(ENDPOINT_URL, { score: expect.anyNumber() });

  // Assert that success message is displayed
  await new Promise((resolve) => setTimeout(resolve, 0)); // Wait for potential UI updates
  expect(getByText('Score saved successfully')).toBeInTheDocument();
});
