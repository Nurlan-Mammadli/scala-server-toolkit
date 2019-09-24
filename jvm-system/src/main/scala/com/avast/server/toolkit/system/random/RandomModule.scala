package com.avast.server.toolkit.system.random

import java.security.SecureRandom

import cats.effect.Sync

/** Provides random number generators. */
object RandomModule {

  /** Makes [[com.avast.server.toolkit.system.random.Random]] with default random seed. */
  def makeRandom[F[_]: Sync]: F[Random[F]] = Sync[F].delay(Random(new scala.util.Random()))

  /** Makes [[com.avast.server.toolkit.system.random.Random]] with the provided `seed`. */
  def makeRandom[F[_]: Sync](seed: Long): F[Random[F]] = Sync[F].delay(Random(new scala.util.Random(seed)))

  /** Makes [[com.avast.server.toolkit.system.random.Random]] based on [[java.security.SecureRandom]] with default random seed. */
  def makeSecureRandom[F[_]: Sync]: F[Random[F]] = Sync[F].delay(Random(new SecureRandom()))

  /** Makes [[com.avast.server.toolkit.system.random.Random]] based on [[java.security.SecureRandom]] with the provided `seed`. */
  def makeSecureRandom[F[_]: Sync](seed: Array[Byte]): F[Random[F]] = Sync[F].delay(Random(new SecureRandom(seed)))

}
