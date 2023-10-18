/* eslint-disable react-hooks/rules-of-hooks */
import React, {useState} from "react";
import "./createStyle.css";
import { createPost} from "../../store/slices/blogList";
import { useDispatch, useSelector } from "react-redux";
import { useNavigate } from "react-router-dom";

const create = () => {
     const [title,setTitle]=useState('');
    const [category, setCategory]=useState('');
    const [description, setDescription]=useState('');
    const[image, setImage]=useState('');

    const posts = useSelector((state) => state.posts);
    const dispatch=useDispatch();
    const navigate=useNavigate();

    const handleSubmit=(event)=>{
        event.preventDefault();
        dispatch(createPost({id:posts[posts.length -1].id+1, title,category,image,description}));
        navigate('/');
    }

  return (
    <div className="container contact">
        <div className="row">
          <div className="col-md-3">
            <div className="contact-info">
              <img
                src="https://clipground.com/images/create-icon-png-10.png"
                alt="..." className="imgFit"
              />
              <h2>Create Post</h2>
              <h4>We would love to hear from you !</h4>
            </div>
          </div>
          
          <div className="col-md-9">
          <form onSubmit={handleSubmit}>
            <div className="contact-form">
              <div className="form-group">
                <label className="control-label col-sm-2">
                  Title:
                </label>
                <div className="col-sm-10">
                  <input
                    type="text"
                    className="form-control"
                    placeholder="Enter Title"
                    name="title"
                    onChange={e=> setTitle(e.target.value)}
                  />
                </div>
              </div>
              <div className="form-group">
                <label className="control-label col-sm-2" >
                  Category:
                </label>
                <div className="col-sm-10">
                  <input
                    type="text"
                    className="form-control"
                    placeholder="Enter Category"
                    name="category"
                    onChange={e=> setCategory(e.target.value)}
                  />
                </div>
              </div>
              <div className="form-group">
                <label className="control-label col-sm-2" >
                  Image:
                </label>
                <div className="col-sm-10">
                  <input
                    type="text"
                    className="form-control"
                    placeholder="Enter Image Link"
                    name="image"
                    onChange={e=> setImage(e.target.value)}
                  />
                </div>
              </div>
              
              <div className="form-group">
                <label className="control-label col-sm-2">
                  Description:
                </label>
                <div className="col-sm-10">
                  <textarea
                    className="form-control"
                    rows="5"
                    name="description"
                    onChange={e=> setDescription(e.target.value)}
                  ></textarea>
                </div>
              </div>
              <div className="form-group">
                <div className="col-sm-offset-2 col-sm-10">
                  <button type="submit" className="btn btn-success" style={{marginTop:"20px"}}>
                    Submit
                  </button>
                </div>
              </div>
            </div>
            </form>
          </div>
          
        </div>
      </div>

  );
};

export default create;
