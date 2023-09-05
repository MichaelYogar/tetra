import React from "react";
import { Formik, Form, Field, ErrorMessage } from "formik";

const EmailForm = () => {
  const handleSubmit = async (values: any, { setSubmitting }: any) => {
    const config: RequestInit = {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(values),
    };

    const response: Response = await fetch(
      "http://localhost:8080/user",
      config
    );
    const result = await response.text();
    console.log(result);
  };

  return (
    <div>
      <Formik
        initialValues={{ email: "" }}
        validate={(values) => {
          const errors: any = {};

          if (!values.email) {
            errors.email = "Required";
          } else if (
            !/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i.test(values.email)
          ) {
            errors.email = "Invalid email address";
          }
          return errors;
        }}
        onSubmit={handleSubmit}
      >
        {({ isSubmitting }) => (
          <Form>
            <div className="flex flex-row">
              <div>
                <Field
                  className="appearance-none border-2 bg-nice-colour border-black rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:border-purple-500 "
                  type="email"
                  name="email"
                  placeholder="Your email"
                />
              </div>
              <button
                className="bg-pink-500 text-white active:bg-pink-600 font-bold uppercase text-xs px-4 py-2 rounded shadow hover:shadow-md outline-none focus:outline-none ease-linear transition-all duration-150 ml-2"
                type="submit"
                disabled={isSubmitting}
              >
                Submit
              </button>
            </div>
            <ErrorMessage name="email" component="div" />
          </Form>
        )}
      </Formik>
    </div>
  );
};

export default EmailForm;
