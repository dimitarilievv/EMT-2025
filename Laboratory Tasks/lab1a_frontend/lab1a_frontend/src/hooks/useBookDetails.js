import { useEffect, useState } from "react";
import bookRepository from "../repository/bookRepository.js";

const useBookDetails = (id) => {
    const [state, setState] = useState({
        book: null,
    });

    useEffect(() => {
        if (id) {
            bookRepository
                .findById(id)
                .then((response) => {
                    setState((prevState) => ({
                        ...prevState,
                        book: response.data,
                    }));
                })
                .catch((error) => {
                    console.log("Error fetching book:", error);
                });
        }
    }, [id]);

    return state;
};

export default useBookDetails;
