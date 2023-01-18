import React, {Component} from 'react';
import {MapTo} from '@adobe/aem-react-editable-components';

/**
 * Title React component
 */
export const TitleEditConfig = {
   emptyLabel: 'Title Component',
   isEmpty: function(props) {
       return !props || !props.title || props.title.trim().length < 1;
   }
};

export default class TitleComponent extends Component {
    render() {
        if(!this.props.title)
            return "Title component";
        return <div>{this.props.title}</div>;
    }
}

MapTo('react-aem-demo/components/title')(TitleComponent, TitleEditConfig);