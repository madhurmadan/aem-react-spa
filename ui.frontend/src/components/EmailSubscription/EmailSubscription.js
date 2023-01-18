import React, {Component} from 'react';
import { MapTo } from "@adobe/aem-react-editable-components";
require('./EmailSubscription.scss');

const EmailSubscriptionEditConfig = {
    emptyLabel: 'Email Subscription',
    isEmpty: function(props) {
        return !props || !props.subscriptionTitle || props.subscriptionTitle.trim().length < 1;
    }
};

export default class EmailSubscription extends Component {
    render() {      
      return (<><br></br><br></br> <div className="custom-message" data-element-validation={this.props.validationMessage}></div><div className="component container">
          <div className="component-content">
              <div className="component content automate-pagecontent-connectwithus col-12">
                  <div className="component-content">
                      <section className="subscription">
                          <div className="container">
                              <div className="row">
                                  <div className="email-sub">
                                      <h4 className="field-subheader">{this.props.subscriptionTitle}</h4>
                                      <div className="component sitecore-form col-12">
                                          <div className="component-content">
                                              <form method="post" style={{right: '15px'}}>
                                                  <div className="ixm-form">
                                                      <input id="emailValue" className="form-box" type="text"  maxLength="255" placeholder={this.props.placeholder}/>
                                                      <input type="submit" className="form-button" value="Subscribe" />
                                                  </div>
                                                  <input type="hidden" data-sc-fxb-condition="" value="{}" />
                                              </form>
                                          </div>
                                      </div>
                                  </div>
                              </div>
                          </div>
                      </section>
                  </div>
              </div>
          </div>
      </div><br></br><br></br></>
      );
    }
}

MapTo("react-aem-demo/components/emailSubscription")(EmailSubscription, EmailSubscriptionEditConfig);
