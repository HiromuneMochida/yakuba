package com.example.yakuba.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "account")
public class Account implements UserDetails {

    private static final long serialVersionUID = 1L;

    /** 権限の種類 */
    public enum Authority {
        ROLE_USER, ROLE_ADMIN
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "enabled")
    private boolean enabled;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Authority role;

    /** コンストラクタ */
    public Account(Long userId, String userName, String password) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.enabled = true;
        this.role = Authority.ROLE_USER;
    }

    public Account() {
    }

    /** ユーザーID */
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /** ユーザー名を返却する -> implements UserDetails */
    @Override
    public String getUsername() {
        return userName;
    }

    public void setUsername(String userName) {
        this.userName = userName;
    }

    /** パスワード */
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /** 権限 */
    public Authority getRole() {
        return role;
    }

    public void setRole(Authority role) {
        this.role = role;
    }

    /** ユーザーに与えられている権限リストを返却する -> implements UserDetails */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(this.role.toString()));

        return authorities;
    }

    /** 有効なユーザーかを判定する -> implements UserDetails */
    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /** アカウントのロック状態を判定する -> implements UserDetails */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /** 資格情報の有効期限の状態を判定する -> implements UserDetails */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /** アカウントの有効期限の状態を判定する -> implements UserDetails */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

}
