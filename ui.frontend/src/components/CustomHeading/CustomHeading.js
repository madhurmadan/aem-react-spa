import React, {Component} from 'react';
import { MapTo } from "@adobe/aem-react-editable-components";
require('./CustomHeading.scss');

const CustomHeadingEditConfig = {
    emptyLabel: 'Custom Heading',
    isEmpty: function(props) {
        return !props || !props.heading || props.heading.trim().length < 1;
    }
};

export default class CustomHeading extends Component {
    render() {
      let headingElement = this.props.headingType ? React.createElement(this.props.headingType, {className: this.props.headingColor},this.props.heading) : '';
      return (<div className="heading"> {headingElement} </div>);
    }
}

MapTo("react-aem-demo/components/custom-heading")(CustomHeading, CustomHeadingEditConfig);
