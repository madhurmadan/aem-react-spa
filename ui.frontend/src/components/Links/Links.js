import React, {Component} from 'react';
import { MapTo } from "@adobe/aem-react-editable-components";
import {Link} from "react-router-dom";
require('./Links.scss');

const LinksEditConfig = {
    emptyLabel: 'Link Component',
    isEmpty: function(props) {
        return !props;
    }
};

export default class Links extends Component {
    render() {      
      let linkItems=this.props.linkItems;
      return (  
      <><br></br><br></br>
      <h4 className="field-title field-title">Connect With Us</h4>
        <ul className="social-list">{linkItems.map(linkItem =>     
            <li>               
                <Link to={linkItem.linkUrl} target={linkItem.linkCheckbox}>
                    <img src={linkItem.imageUrl} alt={linkItem.altText} />   
                </Link>                
            </li>
        )}
        </ul>
    </>
        );
    }
}

MapTo("react-aem-demo/components/links")(Links, LinksEditConfig);
