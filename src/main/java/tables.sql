CREATE TABLE Member (
    id integer primary key generated always as identity, -- 主鍵
    username varchar(50) not null, -- 使用者名稱
    password varchar(50) not null, -- 使用者密碼
    email varchar(50) not null, -- 電子郵件信箱
    code varchar(50) not null, -- Email 認證編碼
    pass boolean, -- Email 是否通過驗證
    passts timestamp, -- Email 通過驗證時間
    priority integer, -- 使用者權限
    ts timestamp default current_timestamp -- 建檔時間
)

