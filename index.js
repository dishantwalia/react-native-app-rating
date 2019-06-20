/**
 * Copyright (c) 2019-Present, Punchh, Inc.
 * All rights reserved.
 *
 * @flow
 */
'use strict';

import { NativeModules, Platform } from 'react-native';
const bridge = NativeModules.RNAppRating;

// Show App Rating Dialog
const showAppRatingDialog = applicationID => {
	if (Platform.OS === 'ios') {
		return bridge.showAppRatingDialog();
	} else {
		// Show Dialog and open url
		return bridge.showAppRatingDialog(applicationID);
	}
};

module.exports = {
	showAppRatingDialog
};
