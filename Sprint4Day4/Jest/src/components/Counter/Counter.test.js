import { render, fireEvent, screen } from "@testing-library/react";
import Counter from "./Counter";

describe("Counter", () => {
  test("renders initial count", () => {
    render(<Counter />);
    expect(screen.getByText(/current: 0/i)).toBeInTheDocument();
  });

  test("increments count", () => {
    render(<Counter />);
    fireEvent.click(screen.getByLabelText("increase"));
    expect(screen.getByText(/current: 1/i)).toBeInTheDocument();
  });

  test("decrements count", () => {
    render(<Counter />);
    fireEvent.click(screen.getByLabelText("decrease"));
    expect(screen.getByText(/current: -1/i)).toBeInTheDocument();
  });
});
