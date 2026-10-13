+++
title = "ReactNativeでインディケーターを表示する"
url = "2018-08-16"
date = "2018-08-16"
description = "ReactNativeでインディケーターを表示する"
tags = ["React Native"]
categories = ["React Native"]
archives = "2018/08"
+++

<br>

ReactNativeでIndicatorを表示するサンプルです。  
react-native: 0.56.0  

![alt](1.png)

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

