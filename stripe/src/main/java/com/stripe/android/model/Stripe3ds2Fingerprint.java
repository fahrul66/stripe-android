package com.stripe.android.model;

import android.support.annotation.NonNull;

import org.json.JSONException;
import org.json.JSONObject;

class Stripe3ds2Fingerprint {
    private static final String FIELD_TYPE = "type";
    private static final String FIELD_THREE_D_SECURE_2_SOURCE = "three_d_secure_2_source";
    private static final String FIELD_DIRECTORY_SERVER_NAME = "directory_server_name";
    private static final String FIELD_SERVER_TRANSACTION_ID = "server_transaction_id";

    private static final String TYPE = "stripe_3ds2_fingerprint";

    @NonNull final String source;
    @NonNull final String directoryServerName;
    @NonNull final String serverTransactionId;

    @NonNull
    static Stripe3ds2Fingerprint create(@NonNull JSONObject json) throws JSONException {
        final String type = json.optString(FIELD_TYPE);
        if (!TYPE.equals(type)) {
            throw new IllegalArgumentException(
                    "Expected JSON with type='stripe_3ds2_fingerprint'. " +
                            "Received type='" + type + "'");
        }

        final String source = json.getString(FIELD_THREE_D_SECURE_2_SOURCE);
        final String directoryServerName = json.getString(FIELD_DIRECTORY_SERVER_NAME);
        final String serverTransactionId = json.getString(FIELD_SERVER_TRANSACTION_ID);
        return new Stripe3ds2Fingerprint(source, directoryServerName, serverTransactionId);
    }

    private Stripe3ds2Fingerprint(@NonNull String source,
                                  @NonNull String directoryServerName,
                                  @NonNull String serverTransactionId) {
        this.source = source;
        this.directoryServerName = directoryServerName;
        this.serverTransactionId = serverTransactionId;
    }
}
