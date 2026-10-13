+++
title = "ReactNativeで画像を表示する"
url = "2018-08-15"
date = "2018-08-15"
description = "ReactNativeで画像を表示する"
tags = ["React Native"]
categories = ["React Native"]
archives = "2018/08"
+++

<br>

ReactNativeで画像を表示するサンプルです。  
iOSで画像をインターネットから取得する場合はATSを設定する必要があるので気をつけてください。  

react-native: 0.56.0

![alt](1.png)
![alt](2.png)

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
    ActivityIndicator,
    View
} from 'react-native';
import {name as appName} from './app.json';

export class App extends Component {

    render() {
        return (
            <View style={styles.container}>
                <ActivityIndicator
                    size="large"
                    color="red" />
            </View>
        );
    }
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        marginTop: 20
    },
});

AppRegistry.registerComponent(appName, () => App);

```

