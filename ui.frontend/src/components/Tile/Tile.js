import React, {Component} from 'react';
import { MapTo } from "@adobe/aem-react-editable-components";
require('./Tile.scss');

const TileEditConfig = {
    emptyLabel: 'Tile',
    isEmpty: function(props) {
        return !props || !props.title || props.title.trim().length < 1;
    }
};



export default class Tile extends Component {
    
    get upperQuote() {
        if(this.props.quotes) {
            return (
                <div className="quotes opening field-quotes-opening">
                <img src="/apps/ixm-aem/clientlibs/clientlib-site/resources/images/Quote_White.svg" alt="not working"  />
            </div>
            );
        }
        return null;
    }   

    get lowerQuote() {
        if(this.props.quotes) {
            return (
                <div className="quotes closing field-quotes-closing">
                            <img src="/apps/ixm-aem/clientlibs/clientlib-site/resources/images/Quote_Green.svg" alt="Not working" />
                        </div>
            );
        }
        return null;
    } 
    

    render() {      
      let tileItems=this.props.tileItems;
      let layoutView=this.props.layout;
      let layoutClass=null;
      if(layoutView==='3x3'){
        layoutClass='col-4 col-sm-4 col-md-4 col-lg-4 col-xl-4 tileCount';
      }
      if(layoutView==='2x2')
      {
        layoutClass='col-6 col-sm-6 col-md-6 col-lg-6 col-xl-6 tileCount';
      }
      return (        
        <div id="myComp" className="component info col-12" >
            <div className="component-content">
                <div className="container info-complete">
                    <div>
                        <h2 className="field-title">{this.props.title}</h2>
                        <div className="field-description-subtitle">{this.props.subTitle}</div>                       
                    </div>
                    <div className="quote">
                    {this.upperQuote}          
                        <div className="component row">{tileItems.map(tileItem =>                                                     
                            <div className={layoutClass} key={tileItem.title+'1'}>                                
                                <div className="component imagetexttile col-12">
                                    <div className="component-content">
                                        <div className="white-card-container">
                                            <div className="white-card"  style={{paddingTop: '50px'}}> 
                                                <><h3 className="field-title">{tileItem.title}</h3><div className="field-description">
                                                    {tileItem.description}
                                                    <div>&nbsp;</div>
                                                </div></>                                            
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>)}
                        </div>
                    {this.lowerQuote}   
                    </div>                    
                </div>
            </div>   
            <br></br><br></br><br></br><br></br>    
        </div>);
    }
}

MapTo("react-aem-demo/components/tile")(Tile, TileEditConfig);
