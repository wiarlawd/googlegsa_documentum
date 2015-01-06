// Copyright 2014 Google Inc. All Rights Reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.enterprise.adaptor.documentum;

import com.google.enterprise.adaptor.AbstractAdaptor;
import com.google.enterprise.adaptor.AdaptorContext;
import com.google.enterprise.adaptor.Config;
import com.google.enterprise.adaptor.DocId;
import com.google.enterprise.adaptor.DocIdPusher;
import com.google.enterprise.adaptor.Request;
import com.google.enterprise.adaptor.Response;

import java.util.logging.Logger;
import java.util.logging.Level;

/** Adaptor to feed Documentum repository content into a 
 *  Google Search Appliance.
 */
public class DocumentumAdaptor extends AbstractAdaptor {
  private static Logger logger =
      Logger.getLogger(DocumentumAdaptor.class.getName());

  public static void main(String[] args) {
    AbstractAdaptor.main(new DocumentumAdaptor(), args);
  }

  @Override
  public void initConfig(Config config) {
    config.addKey("dctm.username", null);
    config.addKey("dctm.userpassword", null);
    config.addKey("dctm.docbasename", null);
  }

  @Override
  public void init(AdaptorContext context) throws Exception {
    Config config = context.getConfig();
    try {
      new DctmSession(config);
    } catch (RepositoryException e) {
      logger.log(Level.SEVERE, "Error creating Documentum session: {0}",
          e.getMessage());
    }
  }

  /** Get all doc ids from documentum repository. */
  @Override
  public void getDocIds(DocIdPusher pusher) {
  }

  /** Gives the bytes of a document referenced with id. */
  @Override
  public void getDocContent(Request req, Response resp) {
  }
}