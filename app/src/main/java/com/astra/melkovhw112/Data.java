package com.astra.melkovhw112;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class Data {
    public static List<Design> prepareContent(Context context) {
        List<Design> result = new ArrayList<>();

        String[] values = context.getString(R.string.large_text).split("\n\n");
        for(int i = 0; i < values.length; i++) {

            /* header */
            String header = values[i].trim();
            i++;

            /* paragraphs */
            StringBuilder content = new StringBuilder();
            while(values[i].length() > 100) {
                /* add paragraph to header */
                content.append(values[i].trim());

                /* check next paragraph - this header? */
                i++;

                /* check end data */
                if(i >= values.length - 1) {
                    break;
                }
            }
            i--;

            /* add header + paragraph */
            Design item = new Design(header, content.toString());
            result.add(item);
        }

        return result;
    }
}
