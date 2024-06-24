import { Navbar1, Navbar1Defaults } from "./components/Navbar";
import { Footer3, Footer3Defaults } from "./components/Footer";
import { Header77, Header77Defaults } from "./components/Hero";

export default function Home() {
  return (
    <>
      <Navbar1 {...Navbar1Defaults} />
      <main>
        <Header77{...Header77Defaults} />
      </main>
      <Footer3 {...Footer3Defaults} />
    </>
  );
}