import { configureStore } from "@reduxjs/toolkit";
import blogList from "./slices/blogList";

const store=configureStore({
    reducer:{
        posts:blogList,
    }
});
export default store;