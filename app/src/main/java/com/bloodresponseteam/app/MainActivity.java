
package com.bloodresponseteam.app;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.*;

public class MainActivity extends Activity {

    int red = Color.rgb(190, 25, 45);
    int dark = Color.rgb(45, 35, 38);
    int light = Color.rgb(250, 247, 247);

    LinearLayout main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showHome();
    }

    GradientDrawable shape(int color, int radius) {
        GradientDrawable bg = new GradientDrawable();
        bg.setColor(color);
        bg.setCornerRadius(radius);
        return bg;
    }

    TextView text(String value, int size, int color) {
        TextView t = new TextView(this);
        t.setText(value);
        t.setTextSize(size);
        t.setTextColor(color);
        t.setGravity(Gravity.CENTER_VERTICAL);
        return t;
    }

    TextView heading(String value) {
        TextView t = text(value, 19, dark);
        t.setTypeface(null, Typeface.BOLD);
        t.setPadding(4, 18, 4, 12);
        return t;
    }

    void showHome() {
        ScrollView scroll = new ScrollView(this);
        scroll.setBackgroundColor(light);

        main = new LinearLayout(this);
        main.setOrientation(LinearLayout.VERTICAL);
        main.setPadding(18, 18, 18, 25);

        scroll.addView(main);

        // Header
        LinearLayout header = new LinearLayout(this);
        header.setOrientation(LinearLayout.VERTICAL);
        header.setPadding(20, 22, 20, 22);
        header.setBackground(shape(red, 22));

        TextView name = text("🩸 Blood Response Team", 23, Color.WHITE);
        name.setTypeface(null, Typeface.BOLD);

        TextView subtitle = text(
            "একতা • সহযোগিতা • সংগঠন",
            14, Color.WHITE
        );

        header.addView(name);
        header.addView(subtitle);

        main.addView(header);

        // Welcome
        TextView welcome = heading("স্বাগতম আমাদের সংগঠনে");
        main.addView(welcome);

        TextView info = text(
            "সংগঠনের সদস্য, যোগাযোগ ও হিসাব ব্যবস্থাপনার " +
            "জন্য একটি নিজস্ব ডিজিটাল প্ল্যাটফর্ম।",
            14, dark
        );
        main.addView(info);

        // Notice
        main.addView(heading("📢 লাইভ নোটিশ"));

        LinearLayout notice = new LinearLayout(this);
        notice.setPadding(16, 16, 16, 16);
        notice.setBackground(shape(Color.WHITE, 16));

        TextView noticeText = text(
            "এখনো কোনো নতুন নোটিশ প্রকাশ করা হয়নি।",
            14, dark
        );
        notice.addView(noticeText);
        main.addView(notice);

        // Notifications
        main.addView(heading("🔔 যোগাযোগ ও আপডেট"));

        addButton("🔔  নোটিফিকেশন", "notifications");
        
        // Members
        main.addView(heading("👥 সদস্য ব্যবস্থাপনা"));

        addButton("👥  সদস্যদের তালিকা", "members");
        addButton("👤  আমার প্রোফাইল", "profile");

        // Communication
        main.addView(heading("💬 যোগাযোগ ব্যবস্থা"));

        addButton("💬  ব্যক্তিগত মেসেজ", "private_chat");
        addButton("👥  গ্রুপ চ্যাট", "group_chat");
        addButton("📞  অডিও কল", "audio_call");
        addButton("☎️  সরাসরি ফোন কল", "phone");
        addButton("🟢  WhatsApp", "whatsapp");

        // Accounts
        main.addView(heading("💰 আর্থিক ব্যবস্থাপনা"));

        addButton("💰  টাকার হিসাব", "accounts");
        addButton("📋  বাকি হিসাব", "dues");

        // Organization
        main.addView(heading("📢 সংগঠন"));

        addButton("📢  Live Notice", "notice");
        addButton("⚙️  Admin Panel", "admin");

        TextView footer = text(
            "Blood Response Team\nসংগঠনের নিজস্ব অ্যাপ",
            13, red
        );
        footer.setGravity(Gravity.CENTER);
        footer.setPadding(5, 28, 5, 15);
        main.addView(footer);

        setContentView(scroll);
    }

    void addButton(String title, String action) {
        Button btn = new Button(this);
        btn.setText(title);
        btn.setTextColor(dark);
        btn.setTextSize(15);
        btn.setAllCaps(false);
        btn.setGravity(Gravity.CENTER_VERTICAL);
        btn.setPadding(18, 8, 12, 8);
        btn.setBackground(shape(Color.WHITE, 15));
        
        LinearLayout.LayoutParams params =
            new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                58
            );

        params.setMargins(0, 5, 0, 5);
        main.addView(btn, params);

        btn.setOnClickListener(v -> {
            Toast.makeText(
                this,
                "এই ফিচারটি পরবর্তী ধাপে চালু করা হবে।",
                Toast.LENGTH_SHORT
            ).show();
        });
    }
    }
