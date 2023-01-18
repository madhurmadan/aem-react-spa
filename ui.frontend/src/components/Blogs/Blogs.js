import React, {Component} from 'react';
import { MapTo } from "@adobe/aem-react-editable-components";
import {Link} from "react-router-dom";

require('./Blogs.scss');

const BlogsEditConfig = {
    emptyLabel: 'Blogs',
    isEmpty: function(props) {
        return !props || !props.title || props.title.trim().length < 1;
    }
};

export default class Blogs extends Component {
    

    render() {
      //let headingElement = this.props.headingType ? React.createElement(this.props.headingType, {className: this.props.headingColor},this.props.heading) : '';
      let blogItems=this.props.blogItems;
      return (
        <>
        <br></br><br></br>  
        <div className="component-content">            
              <h3 className="article-title" >{this.props.title}</h3>
              <h2><span >{this.props.subtitle}</span></h2>
              <h1><span >{this.props.desc}</span></h1>
          </div>
          <div >
          <div className="row component column-splitter">{blogItems.map(blogItem =>                                                     
                    <div className="col-6" key={blogItem.blogTitle+'1'}>
                        <div className="component imagetexttile promo col-12 blue-colour-background">
                            <div className="component-content">
                                <div className="row">   
                                    <div className="leader-image col-4">
                                        <img src={blogItem.blogImage} alt="Blog" />                                        
                                        </div>                                   
                                    <div className="col-md-8 leader-description field-description" >
                                        <Link to={blogItem.blogLinkUrl}><h4>{blogItem.blogTitle}</h4></Link>
                                        <a href="https://www.google.com/">Click</a>
                                        <h3 >{blogItem.blogSubTitle}</h3>
                                        <p>{blogItem.blogDescription}</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>                      
          )} </div></div></>                
        );
    }
}

MapTo("react-aem-demo/components/blogs")(Blogs, BlogsEditConfig);
