package com.example.saurabhomer.chat;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.stfalcon.chatkit.dialogs.DialogsList;
import com.stfalcon.chatkit.dialogs.DialogsListAdapter;

import java.util.ArrayList;

public class MainActivity extends DemoDialogsActivity
{

    private ArrayList<Dialog> dialogs;

    public static void open(Context context) {
        context.startActivity(new Intent(context, MainActivity.class));
    }

    private DialogsList dialogsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialogsList = (DialogsList) findViewById(R.id.dialog);
        initAdapter();
    }

    private void initAdapter() {
        super.dialogsAdapter = new DialogsListAdapter<com.example.saurabhomer.chat.Dialog>(super.imageLoader);
        super.dialogsAdapter.setItems(DialogsFixtures.getDialogs());

        super.dialogsAdapter.setOnDialogClickListener(this);
        super.dialogsAdapter.setOnDialogLongClickListener(this);
        dialogsList.setAdapter(super.dialogsAdapter);
    }

    //for example
    private void onNewMessage(String dialogId, Message message) {
        boolean isUpdated = dialogsAdapter.updateDialogWithMessage(dialogId, message);
        if (!isUpdated) {
            //Dialog with this ID doesn't exist, so you can create new Dialog or update all dialogs list
        }
    }

    //for example
    private void onNewDialog(com.example.saurabhomer.chat.Dialog dialog)
    {
        dialogsAdapter.addItem(dialog);
    }

    @Override
    public void onDialogClick(com.example.saurabhomer.chat.Dialog dialog) {
        Toast.makeText(this, "sasa", Toast.LENGTH_SHORT).show();
    }
}
