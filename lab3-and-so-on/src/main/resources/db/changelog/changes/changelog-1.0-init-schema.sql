CREATE TABLE "user" (
    "id" BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    "username" TEXT UNIQUE NOT NULL,
    "password_hash" TEXT NOT NULL,
    "first_name" TEXT NOT NULL,
    "last_name" TEXT NOT NULL,
    "patronymic" TEXT
);

CREATE TABLE "cinema" (
    "id" BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    "name" TEXT NOT NULL,
    "address" TEXT NOT NULL,
    "latitude" DECIMAL(10, 7) NOT NULL,
    "longitude" DECIMAL(10, 7) NOT NULL
);

CREATE TABLE "movie" (
    "id" BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    "title" TEXT NOT NULL,
    "description" TEXT,
    "duration" INT
);

CREATE TABLE "seance" (
    "id" BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    "cinema_id" BIGINT NOT NULL REFERENCES "cinema"("id"),
    "movie_id" BIGINT NOT NULL REFERENCES "movie"("id"),
    "start_date_time" TIMESTAMPTZ NOT NULL
);

CREATE TABLE "order" (
    "id" BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    "seance_id" BIGINT NOT NULL REFERENCES "seance"("id"),
    "user_id" BIGINT NOT NULL REFERENCES "user"("id")
);