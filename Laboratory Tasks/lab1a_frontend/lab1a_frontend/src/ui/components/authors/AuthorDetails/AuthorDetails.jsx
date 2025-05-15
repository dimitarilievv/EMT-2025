import React from 'react';
import {useNavigate, useParams} from "react-router";
import useAuthorDetails from "../../../../hooks/useAuthorDetails.js";
import PublicIcon from '@mui/icons-material/Public';


import {
    Box,
    Button,
    Chip,
    CircularProgress,
    Grid,
    Typography,
    Paper,
    Avatar,
    Stack,
    Rating,
    Breadcrumbs,
    Link
} from "@mui/material";
import {
    ArrowBack,
    Factory,
    Star,
    ShoppingCart,
    FavoriteBorder,
    Share
} from "@mui/icons-material";
import useCountryDetails from "../../../../hooks/useCountryDetails.js";
import useCountries from "../../../../hooks/useCountries.js";

const AuthorDetails = () => {
    const navigate = useNavigate();
    const {id} = useParams();
    const {author} = useAuthorDetails(id);//todo: add country
    const { countries, loading: loadingCountries }  = useCountries(id);
    console.log("Route param id:", id);

    const country = countries.find(c => c.id === author?.countryId);

    if (!author || loadingCountries || !country) {
        return <CircularProgress />;
    }

    return (
        <Box>
            <Breadcrumbs aria-label="breadcrumb" sx={{mb: 3}}>
                <Link
                    underline="hover"
                    color="inherit"
                    href="#"
                    onClick={(e) => {
                        e.preventDefault();
                        navigate("/authors");
                    }}
                >
                    Authors
                </Link>
                <Typography color="text.primary">{author.name}</Typography>
            </Breadcrumbs>

            <Paper elevation={2} sx={{p: 4, borderRadius: 4}}>
                <Grid container spacing={4}>
                    <Grid size={{xs: 12, md: 9}}>
                        <Box sx={{mb: 3}}>
                            <Typography variant="h5" gutterBottom sx={{fontWeight: 600}}>
                                Author name: {author.name}
                            </Typography>
                            <Typography variant="h5" gutterBottom sx={{fontWeight: 600}}>
                                Author surname: {author.surname}
                            </Typography>
                            <Stack direction="row" spacing={1} sx={{mb: 3}}>
                                <Chip
                                    icon={<PublicIcon />}
                                    label={country.name}
                                    color="primary"
                                    variant="outlined"
                                    sx={{ p: 2 }}
                                />
                            </Stack>
                        </Box>
                    </Grid>
                    <Grid size={12} display="flex" justifyContent="space-between">
                            <Button
                                variant="outlined"
                                startIcon={<Share/>}
                            >
                                Share
                            </Button>
                        <Button
                            variant="outlined"
                            startIcon={<ArrowBack/>}
                            onClick={() => navigate("/authors")}
                        >
                            Back to Authors
                        </Button>
                    </Grid>
                </Grid>
            </Paper>
        </Box>
    );
};

export default AuthorDetails;
