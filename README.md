## Install

### Install Hugo

```
$ brew install hugo
```

Reference: https://gohugo.io/getting-started/installing/


### Install Dependency

```
$ git clone https://github.com/takoikatakotako/swiswiswift.com/
$ cd swiswiswift.com
$ git checkout develop # if needed
$ git submodule update --init --recursive
```


## Build

```
$ cd swiswiswift.com
$ hugo
$ cd public
$ php -S localhost:8000 
```


## Start Development Server

```
$ cd swiswiswift.com
$ hugo server -D
```
