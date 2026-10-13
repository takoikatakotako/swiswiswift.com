+++
title = "ReactNativeで画像をボタンにする(TouchableOpacity)"
url = "2018-08-19"
date = "2018-08-19"
description = "ReactNativeで画像をボタンにする(TouchableOpacity)"
tags = ["React Native"]
categories = ["React Native"]
archives = "2018/08"
+++

<br>

ReactNativeで画像などのViewをボタンにするTouchableOpacityの実装サンプルです。  
カビゴンの画像をタップするとアラートが表示します。  

react-native: 0.56.0  

![alt](1.gif)

<!-- Google Ads -->
{{< google-ads >}}

<!-- Amazon Ads -->
{{< amazon-ads >}}

<!--more-->

**index.js**

```javascript
import React, {Component} from 'react';
import {AppRegistry} from 'react-native';
import {
    StyleSheet,
    Button,
    TouchableOpacity,
    View,
    Alert,
    Image
} from 'react-native';
import {name as appName} from './app.json';

export class App extends Component {

    render() {
        return (
            <View style={styles.container}>
                <TouchableOpacity
                    onPress={() => Alert.alert('Hello')}>
                    <Image
                        style={styles.image}
                        source={require('./image/kabigon.png')}
                    />
                </TouchableOpacity>
            </View>
        );
    }
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
    },
    image: {
        width: 250,
        height: 250,
    }
});

AppRegistry.registerComponent(appName, () => App);

```

