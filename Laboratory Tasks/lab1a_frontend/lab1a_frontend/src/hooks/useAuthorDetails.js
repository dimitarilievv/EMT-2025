import authorRepository from "../repository/authorRepository.js";
import { useEffect, useState } from "react";

const useAuthorDetails = (id) => {
    const [state, setState] = useState({
        author: null,
        country: null,
    });

    useEffect(() => {
        if (!id) return;

        authorRepository
            .findById(id)
            .then((response) => {
                console.log(id);

                const author = {
                    id: response.data.id,
                    name: response.data.name,
                    surname: response.data.surname,
                    countryId: response.data.country?.id
                };

                const country = response.data.country ?? null;

                setState({ author, country });
            })
            .catch((error) => {
                console.log("Error fetching author or country:", error);
            });
    }, [id]);

    return state;
};

export default useAuthorDetails;
