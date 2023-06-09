/*
 * Copyright © 2023 Mark Raynsford <code@io7m.com> https://www.io7m.com
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY
 * SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF OR
 * IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */

package com.io7m.quarrel.core;

import org.osgi.annotation.versioning.ProviderType;

import java.util.List;

/**
 * The interface implemented by commands.
 */

@ProviderType
public non-sealed interface QCommandType
  extends QCommandOrGroupType
{
  /**
   * @return The named parameters for the command
   */

  List<QParameterNamedType<?>> onListNamedParameters();

  /**
   * @return The positional parameters for the command
   */

  default QParametersPositionalType onListPositionalParameters()
  {
    return new QParametersPositionalNone();
  }

  /**
   * Execute the command.
   *
   * @param context The command context
   *
   * @return The result of execution
   *
   * @throws Exception On errors
   */

  QCommandStatus onExecute(QCommandContextType context)
    throws Exception;
}
