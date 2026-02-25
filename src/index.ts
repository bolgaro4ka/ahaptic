import { registerPlugin } from '@capacitor/core';

import type { AHapticPlugin } from './definitions';

const AHaptic = registerPlugin<AHapticPlugin>('AHaptic', {
  web: () => import('./web').then((m) => new m.AHapticWeb()),
});

export * from './definitions';
export { AHaptic };
