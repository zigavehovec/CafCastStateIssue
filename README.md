### Android Sender not receiving CastStateListener event after updating to `cast-framework` version`22.0.0`

After updating to the latest `cast-framework` version `22.0.0`, the CastStateListener is not
triggered initially even though Cast devices are available on the network.
Most of the time the CastStateListener is triggered after a few minutes, as seen in the following log:

```
11:02:26.905  D  Cast state: 1
11:03:53.420  D  Cast state changed: 2
```

Using the previous `cast-framework` version `21.4.0`, we can see that the CastStateListener is
triggered almost immediately after the app is launched.

```
11:07:51.762  D  Cast state: 1
11:07:51.938  D  Cast state changed: 2
```

### Steps to reproduce

- Run the app and look for the Cast state log
- Change the `cast-framework` version to `21.4.0` in the `libs.versions.toml` file and run again to
  verify that it does work as expected with the older version

### Versions

- `cast-framework` version: `22.0.0`
- `media-router` version: `1.7.0`
- minSdkVersion: `21`
- targetSdkVersion: `35`

### Tested on

- Pixel 4a (Android 13)
- Pixel 7 (Android 15)
