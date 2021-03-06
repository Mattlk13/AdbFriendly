package jp.gcreate.plugins.adbfriendly.ui;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogEarthquakeShaker;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.ValidationInfo;
import jp.gcreate.plugins.adbfriendly.adb.AdbConnector;
import jp.gcreate.plugins.adbfriendly.util.PluginConfig;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/*
 * ADB Friendly
 * Copyright 2016 gen0083
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

public class SetAdbPathForm extends DialogWrapper {
    private JPanel     contentPane;
    private JTextField inputtedAdbPath;
    private JLabel     cantConnectLabel;
    private String     adbPath;

    SetAdbPathForm(Project project) {
        super(project);

        setTitle("Set Your ADB Path");
        adbPath = PluginConfig.INSTANCE.getAdbPath();
        inputtedAdbPath.setText(adbPath);
        cantConnectLabel.setVisible(false);

        init();
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        return contentPane;
    }

    @Override
    protected void doOKAction() {
        boolean connected = AdbConnector.INSTANCE.connectAdbWithPath(adbPath);
        cantConnectLabel.setVisible(!connected);
        cantConnectLabel.invalidate();
        if (connected) {
            PluginConfig.INSTANCE.setAdbPath(adbPath);
            PluginConfig.INSTANCE.save();
            super.doOKAction();
        }else {
            DialogEarthquakeShaker.shake((JDialog)getPeer().getWindow());
        }
    }

    @Nullable
    @Override
    protected ValidationInfo doValidate() {
        String path = inputtedAdbPath.getText();
        if (path != null) {
            adbPath = path.trim();
            if (adbPath.length() == 0) {
                return new ValidationInfo("Input your adb path.", inputtedAdbPath);
            }
        }
        return null;
    }
}
