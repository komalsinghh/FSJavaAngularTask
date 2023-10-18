/* eslint-disable eqeqeq */
import { createSlice } from "@reduxjs/toolkit";
import { blogList } from "../../config/data";

const postSlice = createSlice({
  name: "posts",
  initialState: blogList,
  reducers: {
    createPost: (state, action)=>{
      console.log(action);
      state.push(action.payload);
    },
    updatePost: (state, action)=>{
      const {id,title,category,description}=action.payload;
      const up=state.find(post=> post.id==id);
     if(up){
        up.title=title;
        up.category=category;
        up.description=description;
      }
    },
    deletePost: (state, action)=>{
      const {id}=action.payload;
      const up=state.find(post=> post.id==id);
      if(up){
        return state.filter(f=> f.id!==id)
      }
    },
  },
});
export const {createPost, updatePost, deletePost}=postSlice.actions;
export default postSlice.reducer;
