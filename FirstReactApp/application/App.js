import React, {Component} from 'react';
import {
    Text,
    TextInput,
    View,
    Image,
    StyleSheet,
    Button,
    Alert
} from 'react-native';

import {TextField} from 'react-native-material-textfield';
import { TextButton, RaisedTextButton } from 'react-native-material-buttons';

export default class App extends Component {

     constructor (props) {
          super(props);
          this.state={
              login:'',
              password:''
          }
      }

   handlePress = async () => {
        Alert.alert("Hello")
}

    render() {
        return (
            <View style={styles.container}>
              <Image 
              source={require('./assets/images/logo2.png')}/>
                <TextField
                    label='Логин'
                    tintColor='#0066ff'
                    baseColor='#3366ff'
                />
                <TextField 
                    label='Пароль'
                    secureTextEntry={true}
                    tintColor='#0066ff'
                    baseColor='#3366ff'
                />
                <RaisedTextButton style={{marginTop:40}} title='Войти' titleColor='white' color='#3399ff'
                onPress={this.handlePress.bind(this)}/>
            </View>
        );
    }
}

const styles = StyleSheet.create({
    container: {
      margin: 15,
      marginTop: '50%'
    }
});
