import { WebPlugin } from '@capacitor/core';

import type { AHapticPlugin } from './definitions';

export class AHapticWeb extends WebPlugin implements AHapticPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
