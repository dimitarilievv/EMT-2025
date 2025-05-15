import React from 'react';
import AuthorCard from "../AuthorCard/AuthorCard.jsx";
import {Grid} from "@mui/material";
import AuthorDetails from "../AuthorDetails/AuthorDetails.jsx";

// const handleEditAuthor = async (id, formData) => {
//     await authorRepository.edit(id, formData);
//     await fetchAuthors(); // повлечи ги авторите повторно по измена
// };
const AuthorsGrid = ({authors, onEdit, onDelete}) => {

    return (
        <Grid container spacing={{xs: 2, md: 3}}>
            {authors.map((author) => (
                <Grid key={author.id} size={{xs: 12, sm: 6, md: 4, lg: 3}}>
                    <AuthorCard author={author} onEdit={onEdit} onDelete={onDelete}/>
                </Grid>
            ))}
        </Grid>
    );
};

export default AuthorsGrid;