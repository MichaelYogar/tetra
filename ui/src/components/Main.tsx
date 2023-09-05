"use client";
import { motion } from "framer-motion";
import Form from "./Form";
const Main = () => {
  return (
    <main className="flex flex-col items-center justify-center p-5">
      <div className="flex flex-col items-">
        <p className="text-4xl font-normal leading-normal mt-0 mb-2">
          Unlock Knowledge <br /> Four Questions at a time, <br /> Every week.
        </p>
        <Form />
      </div>
    </main>
  );
};

export default Main;
