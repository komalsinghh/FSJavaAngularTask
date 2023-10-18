/* eslint-disable eqeqeq */
import React,{ useState } from "react";
import { useParams } from "react-router-dom";
import { useSelector } from "react-redux";
import {
  AiFillHeart,
  AiOutlineHeart,
} from "react-icons/ai";

const View = () => {
  const { id } = useParams();
  const posts = useSelector((state) => state.posts);
  const existingPost = posts.filter((f) => f.id == id);
  const { title, category, description, src,authorName, createdAt } = existingPost[0];
// eslint-disable-next-line react-hooks/rules-of-hooks
const [like, setLike] = useState(false);
const[count, setCount]=useState('');
const handleLikes=(id)=> {
  if (!like) {
    setLike(true);
    setCount(count+1);
  } else {
    setLike(false);
   setCount(count-1);
  }
}
  return (
    <div className="container mt-5">
      <div className="row d-flex justify-content-center">
        <div className="col-md-7">
          <div className="card p-3 py-4">
            <div className="text-center">
              <img
                src={src}
                alt="..."
                
              style={{width:"200px", height:"200px"}}/>
            </div>

            <div className="text-center mt-3">
              <h2 className="mt-2 mb-0">{title}</h2>
              <h5 style={{color:"grey"}}>{category}</h5>

              <div className="px-4 mt-1">
                <p className="fonts">
                  {description}
                </p>
              </div>

                <h5 style={{textAlign:"left", color:"grey", marginTop:"20px"}}><i>Created at: </i>{createdAt}  <span style={{color:"#997a8d", marginLeft:"200px"}}>@{authorName}</span></h5>
                {
                     like ? (
                      <AiFillHeart
                        size={33}
                        className="text-danger"
                        onClick={handleLikes}
                        style={{ cursor: "pointer" }}
                      />
                    ) : (
                      <AiOutlineHeart
                        size={33}
                        onClick={handleLikes}
                        style={{ cursor: "pointer" }}
                      />
                    )} <span><b>{`${count}`} Like</b></span>
              
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default View;
