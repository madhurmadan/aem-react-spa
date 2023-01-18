import React, {Component} from 'react';
import { MapTo } from "@adobe/aem-react-editable-components";
import {Link} from "react-router-dom";
require('./Tablinks.scss');

const TablinksEditConfig = {
    emptyLabel: 'Tab Links',
    isEmpty: function(props) {
        return !props;
    }
};

export default class Tablinks extends Component {
   
    render() {            

      let tabs=this.props.tabs;
      return (<><br></br><br></br><br></br><br></br><div className="row">{tabs.map(tabItem => <div className="col-3">
          <div className="component link-list automate-linklist-default col-12">
              <div className="component-content">
                  <><h3>{tabItem.title}</h3><ul>
                      <li className="item0 odd">
                          <div className="field-link">{tabItem.linkItems.map(linkItem => <>
                              <Link to={linkItem.linkUrl}><div>{linkItem.linkText}</div></Link>
                          </>
                          )}
                          </div>
                      </li>
                  </ul></>

              </div>
          </div>
      </div>)}
      </div><br></br><br></br><br></br><br></br></>
  )
    }
}

MapTo("react-aem-demo/components/tabLinks")(Tablinks, TablinksEditConfig);
