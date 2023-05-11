import { render, screen, prettyDOM } from "@testing-library/react";
import { Button } from "../Button";
import styles from "../index.module.css";

describe("Button", () => {
  it("Should appear a button with the color primary and the label provided", () => {
    render(<Button label="Button" />);
    //this for the input
    expect(screen.getByRole("button")).toBeInTheDocument();
    // This is for the content in the button
    expect(screen.getByText("Button")).toBeInTheDocument();
  });
  it("Should appears the secondary className", () => {
    render(<Button label="Button" isSecondary />);
    //this for the input
    console.log(prettyDOM(screen.getByRole("button")));
    // This is for the content in the button
    expect(screen.getByText("Button")).toHaveClass(styles.buttonSecondary);
  });
});
