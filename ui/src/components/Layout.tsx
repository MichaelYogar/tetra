import Header from "./Header";
import { ReactNode, FC } from "react";

export default function Layout({ children }: any) {
  return (
    <>
      <Header />
      <main className="bg-nice-colour">{children}</main>
    </>
  );
}
