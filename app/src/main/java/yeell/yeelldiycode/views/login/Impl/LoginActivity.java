package yeell.yeelldiycode.views.login.Impl;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import yeell.yeelldiycode.R;
import yeell.yeelldiycode.base.BaseActivity;
import yeell.yeelldiycode.models.TokenModel;
import yeell.yeelldiycode.utils.apiutils.ApiCookieMannager;
import yeell.yeelldiycode.utils.apiutils.ApiManagers;
import yeell.yeelldiycode.views.home.Impl.HomeActivity;

/**
 * Created by YeeLL on 11/25/16.
 */

public class LoginActivity extends BaseActivity {

    @BindView(R.id.username)
    TextInputEditText mUserName;
    @BindView(R.id.password)
    TextInputEditText mPassword;
    @BindView(R.id.login)
    Button mLogin;

    @Override
    protected int getContentId() {
        return R.layout.activity_login;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
    }

    @OnClick(R.id.login)
    public void onLogin(View view) {
        ApiCookieMannager.getCookie().getCookieAndToken("97309948", "1b0f75ba32713d58a7b1ea96f000d8da65e42035253c93a65b3998bff8d6df96",
                "password", mPassword.getText().toString().trim(), mUserName.getText().toString().trim())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<TokenModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(mContext, e.toString(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(TokenModel tokenModel) {
                        ApiManagers.setToken(tokenModel.access_token,LoginActivity.this);
                        Toast.makeText(mContext, tokenModel.access_token, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(intent);
                    }
                });
    }
}
