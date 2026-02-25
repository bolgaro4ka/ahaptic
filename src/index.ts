import { registerPlugin } from '@capacitor/core'
import type { AdvancedHapticsPlugin } from './definitions'

export const AdvancedHaptics = registerPlugin<AdvancedHapticsPlugin>(
  'AdvancedHaptics'
)