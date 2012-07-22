package com.teamboid.twitterapi.relationship;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * @author Aidan Follestad
 */
public class IDsJSON implements IDs {

    public IDsJSON(JSONObject json) throws Exception {
        _nextCursor = json.optLong("next_cursor");
        _previousCursor = json.optLong("previous_cursor");
        ArrayList<Long> toSet = new ArrayList<Long>();
        JSONArray ids = json.getJSONArray("ids");
        for(int i = 0; i < ids.length(); i++) {
            toSet.add(ids.getLong(i));
        }
        _ids = toSet.toArray(new Long[0]);
    }

    private Long[] _ids;
    private Long _previousCursor;
    private Long _nextCursor;

    @Override
    public Long getPreviousCursor() { return _previousCursor; }

    @Override
    public Long[] getIds() { return _ids; }

    @Override
    public Long getNextCursor() { return _nextCursor; }
}