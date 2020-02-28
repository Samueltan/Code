import React, { useState } from "react";

export default function Button() {
  const [text, setButtonText] = useState("On");
  console.log('buttonText = ' + text);
  function handleClick() {
    const txt = text === "On" ? "Off" : "On";
    return setButtonText(txt);
  }

  return <button onClick={handleClick}>{text}</button>;
}