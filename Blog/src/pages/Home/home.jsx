import React from "react";
import Header from "../../components/Header/Navbar";
import "../../../node_modules/bootstrap/dist/css/bootstrap.min.css";
import "./homeStyle.css";
import {
  AiFillEdit,
  AiFillDelete,
  AiFillEye,
} from "react-icons/ai";
import { Link } from "react-router-dom";
import { useDispatch, useSelector } from "react-redux";
import { deletePost } from "../../store/slices/blogList";

const home = () => {
  // eslint-disable-next-line react-hooks/rules-of-hooks
  const posts = useSelector((state) => state.posts);
  console.log(posts);
  
  // eslint-disable-next-line react-hooks/rules-of-hooks
  const dispatch=useDispatch();
  const handleDelete=(id)=>{
    console.log("delete func");
    dispatch(deletePost({id:id}));
  }
  return (
    <div>
      <Header />
      <div className="container">
        <div className="row gy-3 my-3">
          {posts.map((post, id) => (
            <div className="col-sm-6 col-md-4 col-lg-4" key={id}>
              <div className="card" style={{ width: "18rem" }}>
                <img src={post.src} alt="..." className="img-fit" />
                <div className="card-body">
                  <h4 className="card-title">{post.title}</h4>
                  <h6 className="card-subtitle mb-2 text-body-secondary">
                    {post.category}
                  </h6>
                  <p className="card-text name-design">
                    {post.description}
                  </p>

                  <AiFillEye size={20} />
                  <Link to={`/view/${post.id}`}>Read Page</Link>
                  <div className="card-footer">
                    
                    <Link to={`/edit/${post.id}`}>
                    <AiFillEdit
                      size={33}
                      className="text-info"
                      style={{ marginLeft: "40px", cursor: "pointer" }}
                    />
                    </Link>
                    <AiFillDelete
                      size={33}
                      className="text-danger"
                      style={{ marginLeft: "60px", cursor: "pointer" }}
                      onClick={()=>handleDelete(post.id)}
                    
                    />
                  </div>
                </div>
              </div>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
};

export default home;
