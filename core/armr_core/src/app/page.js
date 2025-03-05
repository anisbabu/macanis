import Image from "next/image";
import Login from "./pages/login";
import TestComponent from "./pages/TestComponent";

export default function Home() {
  return (
    <div className="grid grid-rows-[20px_1fr_20px] items-center justify-items-center min-h-screen p-8 pb-20 gap-16 sm:p-20 font-[family-name:var(--font-geist-sans)]">
     <TestComponent />
    </div>
  );
}
