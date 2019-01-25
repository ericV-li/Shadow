package com.tencent.shadow.runtime;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;

import java.io.File;

public class ResolverHook {

    public static Uri insert(ContentResolver resolver, Uri url, ContentValues values) {
        Uri containerUri = UriConverter.parse(url.toString());
        return resolver.insert(containerUri, values);
    }

    public static int delete(ContentResolver resolver, Uri url, String where, String[] selectionArgs) {
        Uri containerUri = UriConverter.parse(url.toString());
        return resolver.delete(containerUri, where, selectionArgs);
    }

    public static int update(ContentResolver resolver, Uri uri, ContentValues values, String where, String[] selectionArgs) {
        Uri containerUri = UriConverter.parse(uri.toString());
        return resolver.update(containerUri, values, where, selectionArgs);
    }

    @TargetApi(Build.VERSION_CODES.O)
    public static Cursor query(ContentResolver resolver, Uri uri, String[] projection, Bundle queryArgs,
            CancellationSignal cancellationSignal) {
        Uri containerUri = UriConverter.parse(uri.toString());
        return resolver.query(containerUri, projection, queryArgs, cancellationSignal);
    }

    public static Cursor query(ContentResolver resolver, Uri uri, String[] projection, String selection,
            String[] selectionArgs, String sortOrder) {
        Uri containerUri = UriConverter.parse(uri.toString());
        return resolver.query(containerUri, projection, selection, selectionArgs, sortOrder);
    }

    public static Cursor query(ContentResolver resolver, Uri uri, String[] projection, String selection,
            String[] selectionArgs, String sortOrder,
            CancellationSignal cancellationSignal) {
        Uri containerUri = UriConverter.parse(uri.toString());
        return resolver.query(containerUri, projection, selection, selectionArgs, sortOrder, cancellationSignal);
    }

    public static Bundle call(ContentResolver resolver, Uri uri, String method, String arg, Bundle extras) {
        if (extras == null) {
            extras = new Bundle();
        }
        Uri containerUri = UriConverter.parseCall(uri.toString(), extras);
        return resolver.call(containerUri, method, arg, extras);
    }

    public static int bulkInsert(ContentResolver resolver, Uri url, ContentValues[] values) {
        Uri containerUri = UriConverter.parse(url.toString());
        return resolver.bulkInsert(containerUri, values);
    }

    public static Uri getFileUri(Context context, String authority, File file) {

        return null;
    }
}