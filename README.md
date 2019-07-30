
# `cordova-plugin-networkspeed`

<p align="center">
  <a href="https://badge.fury.io/js/cordova-plugin-networkspeed"><img src="https://badge.fury.io/js/cordova-plugin-networkspeed.svg" alt="npm version" height="18">
  </a>
  <a href="https://codeclimate.com/github/codeclimate/codeclimate/maintainability"><img src="https://api.codeclimate.com/v1/badges/a99a88d28ad37a79dbf6/maintainability" />
  </a>
    <a href="https://opensource.org/licenses/Apache-2.0">
        <img src="https://img.shields.io/badge/License-Apache%202.0-blue.svg" alt="License" />
    </a>
</p>

> Cordova plugin to get network speed (Android)

  ## API

The plugin exposes the following method:

```javascript
networkspeed.getNetworkSpeed(success, error);
```

#### Parameters:
* __success:__ success callback which returns network speed in **KB/s**
* __error:__ error callback


##  Installation

  

The plugin can be installed via [Cordova-CLI](https://cordova.apache.org/docs/en/dev/guide/cli/index.html#The%20Command-line%20Interface) and is publicly available on [NPM](https://www.npmjs.com/package/cordova-plugin-networkspeed).

  

Execute from the projects root folder:

  

$ cordova plugin add cordova-plugin-networkspeed

  

Or install a specific version:

  

$ cordova plugin add cordova-plugin-networkspeed@VERSION

  

Or install the latest head version:

  

$ cordova plugin add https://github.com/swayangjit/cordova-plugin-networkspeed.git

  

Or install from local source:

  

$ cordova plugin add <path> --nofetch --nosave --link