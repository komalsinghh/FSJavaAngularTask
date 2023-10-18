import React, { useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import { useSelector } from 'react-redux';
import { updatePost } from '../../store/slices/blogList';
import { useDispatch } from 'react-redux';

const Update = () => {
    const {id}=useParams();
    const posts = useSelector((state) => state.posts);
    // eslint-disable-next-line eqeqeq
    const existingPost=posts.filter(f=> f.id==id);
    const {title,category,description}=existingPost[0];

    const [utitle,setUtitle]=useState(title);
    const [ucategory, setUcategory]=useState(category);
    const [udescription, setUdescription]=useState(description);
    const dispatch=useDispatch();
    const navigate=useNavigate();

    const handleUpdate=(event)=>{
        event.preventDefault();
        dispatch(updatePost({
            id:id,
            title:utitle,
            category:ucategory,
            description:udescription
        }))
        navigate('/');
    }

  return (
    <div className="container contact">
        <div className="row">
          <div className="col-md-3">
            <div className="contact-info">
              <img
                src="https://th.bing.com/th/id/R.e3d9ab63fdb9b258a62921535e0f8a3a?rik=uhDZS4Ak03dfww&riu=http%3a%2f%2fcdn.onlinewebfonts.com%2fsvg%2fimg_386644.png&ehk=RK039QvKQGHWDkqFd6IH6qStFaYVwvoX1nijQYAiAhk%3d&risl=&pid=ImgRaw&r=0"
                alt="..." className="imgFit"
              />
              <h2>Update Post</h2>
              <h4>We would love to hear from you !</h4>
            </div>
          </div>
          
          <div className="col-md-9">
          <form onSubmit={handleUpdate}>
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
                    value={utitle}
                    onChange={e=> setUtitle(e.target.value)}/>
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
                   value={ucategory}
                   onChange={e=> setUcategory(e.target.value)}/>
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
                   value={udescription}
                   onChange={e=> setUdescription(e.target.value)}></textarea>
                </div>
              </div>
              <div className="form-group">
                <div className="col-sm-offset-2 col-sm-10">
                  <button type="submit" className="btn btn-primary" style={{marginTop:"20px"}}>
                    Update
                  </button>
                </div>
              </div>
            </div>
            </form>
          </div>
          
        </div>
      </div>

  )
}

export default Update