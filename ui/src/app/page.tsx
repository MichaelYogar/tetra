"use client";
import { useEffect, useState } from "react";
import { useForm, SubmitHandler } from "react-hook-form";

type Inputs = {
  email: string | null;
};

export default function Home() {
  const [data, setData] = useState<Inputs>({"email": null});
  const {
    register,
    handleSubmit,
    watch,
    formState: { errors },
  } = useForm<Inputs>();

  const onSubmit: SubmitHandler<Inputs> = (data) => setData(data);

  useEffect(() => {
    const sendEmail = async () => {
      const config : RequestInit = {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
      }

      const response : Response = await fetch("http://localhost:8080/user", config);
      const result = await response.text();
      console.log(result);
    }

    if (data.email)
      sendEmail();

  }, [data]);


  return (
    <form onSubmit={handleSubmit(onSubmit)}>
      <input defaultValue="test" {...register("email")} />
      <input type="submit" value="Subscribe"/>
    </form>
  );
}
