"use client";

import { useState } from "react";
import { Button, Input } from "@relume_io/relume-ui";
import type { ButtonProps } from "@relume_io/relume-ui";
import { BiLogoFacebookCircle, BiLogoGoogle, BiLogoApple } from "react-icons/bi";

type ImageProps = {
    url?: string;
    src: string;
    alt?: string;
};

type Props = {
    logo: ImageProps;
    signUpText: string;
    signUpLink: {
        text: string;
        url: string;
    };
    title: string;
    description: string;
    inputPlaceholderEmail: string;
    inputPlaceholderPassword: string;
    logInButton: ButtonProps;
    socialLoginButtons: ButtonProps[];
    forgotPassword: {
        text: string;
        url: string;
    };
    footerText: string;
};

export type Login2Props = React.ComponentPropsWithoutRef<"section"> & Partial<Props>;

export const Login2 = (props: Login2Props) => {
    const {
        logo,
        signUpText,
        signUpLink,
        title,
        description,
        inputPlaceholderEmail,
        inputPlaceholderPassword,
        logInButton,
        socialLoginButtons,
        forgotPassword,
        footerText,
    } = {
        ...Login2Defaults,
        ...props,
    } as Props;

    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");

    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        console.log({ email, password });
    };

    return (
        <section className="px-[5%]">
            <div className="relative flex min-h-svh flex-col items-stretch justify-center overflow-auto py-24 lg:py-20">
                <div className="absolute bottom-auto left-0 right-0 top-0 flex h-16 w-full items-center justify-between md:h-18">
                    <a href={logo.url}>
                        <img src={logo.src} alt={logo.alt} />
                    </a>
                    <div className="inline-flex gap-x-1">
                        <p className="hidden md:block">{signUpText}</p>
                        <a
                            href={signUpLink.url}
                            className="underline ring-offset-white focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-border-primary focus-visible:ring-offset-2"
                        >
                            {signUpLink.text}
                        </a>
                    </div>
                </div>
                <div className="container max-w-sm">
                    <div className="mb-8 text-center md:mb-10 lg:mb-12">
                        <h1 className="mb-5 text-5xl font-bold md:mb-6 md:text-7xl lg:text-8xl">{title}</h1>
                        <p className="md:text-md">{description}</p>
                    </div>
                    <form className="grid grid-cols-1 gap-4" onSubmit={handleSubmit}>
                        <Input
                            type="email"
                            id="email"
                            placeholder={inputPlaceholderEmail}
                            value={email}
                            onChange={(e) => setEmail(e.target.value)}
                        />
                        <Input
                            type="password"
                            id="password"
                            placeholder={inputPlaceholderPassword}
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                        />
                        <Button
                            variant={logInButton.variant}
                            size={logInButton.size}
                            iconLeft={logInButton.iconLeft}
                            iconRight={logInButton.iconRight}
                        >
                            {logInButton.title}
                        </Button>
                        <div className="my-3 h-px w-full bg-black md:my-4" />
                        {socialLoginButtons.map((button, index) => (
                            <Button
                                key={index}
                                variant={button.variant}
                                size={button.size}
                                iconLeft={button.iconLeft}
                                iconRight={button.iconRight}
                                className="gap-x-3"
                            >
                                {button.title}
                            </Button>
                        ))}
                    </form>
                    <div className="mt-5 w-full text-center md:mt-6">
                        <a
                            href={forgotPassword.url}
                            className="underline ring-offset-white focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-border-primary focus-visible:ring-offset-2"
                        >
                            {forgotPassword.text}
                        </a>
                    </div>
                </div>
                <footer className="absolute bottom-0 left-0 right-0 top-auto flex h-16 w-full items-center justify-center md:h-18">
                    <p className="text-sm">{footerText}</p>
                </footer>
            </div>
        </section>
    );
};

export const Login2Defaults: Login2Props = {
    logo: {
        url: "#",
        src: "https://relume-assets.s3.amazonaws.com/logo-image.svg",
        alt: "Logo text",
    },
    signUpText: "Don't have an account?",
    signUpLink: {
        text: "Sign up",
        url: "#",
    },
    title: "Log In",
    description: "Lorem ipsum dolor sit amet adipiscing elit.",
    inputPlaceholderEmail: "Email",
    inputPlaceholderPassword: "Password",
    logInButton: {
        title: "Log in",
    },
    socialLoginButtons: [
        {
            variant: "secondary",
            title: "Log in with Google",
            iconLeft: <BiLogoGoogle className="size-6" />,
        },
        {
            variant: "secondary",
            title: "Log in with Facebook",
            iconLeft: <BiLogoFacebookCircle className="size-6" />,
        },
        {
            variant: "secondary",
            title: "Log in with Apple",
            iconLeft: <BiLogoApple className="size-6" />,
        },
    ],
    forgotPassword: {
        text: "Forgot your password?",
        url: "#",
    },
    footerText: "© 2024 Relume",
};

Login2.displayName = "Login2";
